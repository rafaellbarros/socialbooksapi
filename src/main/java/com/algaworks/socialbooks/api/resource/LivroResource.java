package com.algaworks.socialbooks.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.socialbooks.api.domain.Comentario;
import com.algaworks.socialbooks.api.domain.Livro;
import com.algaworks.socialbooks.api.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;

	@GetMapping
	public ResponseEntity<List<Livro>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(livroService.listar());
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livro = livroService.salvar(livro);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Livro livro = livroService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(livro);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		livroService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable("id") Long id, @RequestBody Livro livro) {
		livro.setId(id);

		livroService.atualizar(livro);

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/{id}/comentarios")
	public ResponseEntity<Void> adicionarComentario(@PathVariable("id") Long livroId, @RequestBody Comentario comentario) {
		livroService.salvarComentario(livroId, comentario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}/comentarios")
	public ResponseEntity<List<Comentario>> listarComentarios(@PathVariable("id")Long livroId) {
		List<Comentario> comentarios = livroService.listarComentarios(livroId);
		return ResponseEntity.status(HttpStatus.OK).body(comentarios);
	}
}

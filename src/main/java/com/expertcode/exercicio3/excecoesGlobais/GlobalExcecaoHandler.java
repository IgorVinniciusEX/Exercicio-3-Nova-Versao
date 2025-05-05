package com.expertcode.exercicio3.excecoesGlobais;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.expertcode.exercicio3.servicos.excecoes.BancoDeDadosExcecao;
import com.expertcode.exercicio3.servicos.excecoes.RecursoNaoEncontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExcecaoHandler {

    @ExceptionHandler(RecursoNaoEncontradoExcecao.class)
    public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcecao e, HttpServletRequest solicitacao){
        String mensagem = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao(Instant.now(), status.value(), mensagem, e.getMessage(), solicitacao.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(BancoDeDadosExcecao.class)
    public ResponseEntity<ErroPadrao> erroBancoDeDados(BancoDeDadosExcecao e, HttpServletRequest solicitacao){
        String mensagem = "Erro no banco de dados";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erro = new ErroPadrao(Instant.now(), status.value(), mensagem, e.getMessage(), solicitacao.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

}

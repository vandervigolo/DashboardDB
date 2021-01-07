package br.com.dashboarddb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagensUsuario {
	
	/**
	 *  Método que disponibiliza mensagens de informação em tela para o usuário
	 * @param mensagem
	 * 			Mensagem a ser apresentada para o usuário
	 */
	public static void informacao (String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação:", mensagem));	
	}
	
	/**
	 *  Método que disponibiliza mensagens de cuidado em tela para o usuário
	 * @param mensagem
	 * 			Mensagem a ser apresentada para o usuário
	 */
	public static void cuidado (String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cuidado:", mensagem));	
	}
	
	/**
	 *  Método que disponibiliza mensagens de erro em tela para o usuário
	 * @param mensagem
	 * 			Mensagem a ser apresentada para o usuário
	 */
	public static void erro (String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro:", mensagem));	
	}
	
	/**
	 *  Método que disponibiliza mensagens de erro do sistema em tela para o usuário
	 * @param mensagem
	 * 			Mensagem a ser apresentada para o usuário
	 */
	public static void erroSistema (String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro Sistema:", mensagem));	
	}

}

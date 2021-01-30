package br.com.dashboarddb.util;

import java.util.ResourceBundle;

/**
 * Classe responsável pela leitura de arquivos .properties
 * @author vander
 *
 */
public class LeitorProperties {
	
	private static ResourceBundle messagesRB;

	/**
	 * Método responsável por realizar a busca de uma mensagem no arquivo de properties padrão do sistema
	 * @param chave
	 *        valor da chave da mensagem
	 * @return
	 * 		  String correspondente da chave buscada ou null caso não encontre
	 */
	public static String getValor(String chave) {
		messagesRB = ResourceBundle.getBundle("br.com.dashboarddb.bundle.mensagens");
        if (messagesRB.containsKey(chave)) {
            return messagesRB.getString(chave);
        }
        return "";
	}
	
	/**
	 * Método responsável por realizar a busca de uma mensagem no arquivo de properties no pacote identificado
	 * @param chave
	 * 			valor da chave da mensagem
	 * @param pacote
	 * 			pacote onde esta localizado o arquivo + nome do arquivo sem .properties. Ex: br.com.dashboarddb.bundle.mensagens
	 * @return
	 *          String correspondente da chave buscada ou null caso não encontre
	 */
	public static String getValor(String chave, String pacote) {
		messagesRB = ResourceBundle.getBundle(pacote);
        if (messagesRB.containsKey(chave)) {
            return messagesRB.getString(chave);
        }
        return "";
	}	

}

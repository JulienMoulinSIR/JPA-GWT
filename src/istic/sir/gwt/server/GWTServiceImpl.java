package istic.sir.gwt.server;

import istic.sir.gwt.client.GWTService;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {




	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 *
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}


	@Override
	public String gwtServer(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}

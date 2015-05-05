package istic.sir.gwt.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Tp_jpa_gwt2 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	private final GWTServiceAsync gwtService = GWT.create(GWTService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad(){
		final PushButton accueilBtn 	= new PushButton();
		accueilBtn.setHTML("Accueil");
		final PushButton personsBtn 	= new PushButton();
		accueilBtn.setHTML("Liste des personnes");
		final PushButton addPersonBtn 	= new PushButton();
		accueilBtn.setHTML("Ajouter une personne");
		final PushButton submitPersonBtn 	= new PushButton();
		accueilBtn.setHTML("Envoyer");
		final PushButton devicesBtn 	= new PushButton();
		accueilBtn.setHTML("Liste des appareils");
		final PushButton homesBtn 		= new PushButton();
		accueilBtn.setHTML("Liste des maisons");
		
		final HTML html = new HTML();		
		RootPanel.get("insertHTML").add(html);

		// We can add style names to widgets
		accueilBtn.addStyleName("accueilBtn");
		personsBtn.addStyleName("personsBtn");
		addPersonBtn.addStyleName("addPersonBtn");
		devicesBtn.addStyleName("devicesBtn");
		homesBtn.addStyleName("homesBtn");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element

		RootPanel.get("accueilBtnContainer").add(accueilBtn);
		RootPanel.get("personsBtnContainer").add(personsBtn);
		RootPanel.get("addPersonBtnContainer").add(addPersonBtn);
		RootPanel.get("submitPersonBtnContainer").add(submitPersonBtn);
		RootPanel.get("devicesBtnContainer").add(devicesBtn);
		RootPanel.get("homesBtnContainer").add(homesBtn);
		
		// Add handler
		accueilBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				html.setText("<img src='http://www.dakotafinancialnews.com/logos/opower-inc-logo.jpg' class='img-responsive'>"
						+"<h1>Bienvenue sur OPower</h1>"
						+"<p>OPower est un reseau social permettant de comparer sa consommation electrique avec ses amis, voisins, ...</p>"
				);
			}

		});

		personsBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Supprime l'existant
				html.setText("");
				
				String url = "http://localhost:8080/rest/persons/";
				
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
				builder.setHeader("Content-type", "application/json");
				try {
					Request response = builder.sendRequest(null, new RequestCallback() {

						@Override
						public void onResponseReceived(Request request, Response response) {
							// TODO Auto-generated method stub
							html.setHTML(response.getText());
						}

						@Override
						public void onError(Request request, Throwable exception) {
							// TODO Auto-generated method stub
							html.setHTML(exception.getMessage());
						}
					});
				} catch (RequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		personsBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Supprime l'existant
				html.setText("");
				
				String url = "http://localhost:8080/rest/persons/";
				
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
				builder.setHeader("Content-type", "application/json");
				try {
					Request response = builder.sendRequest(null, new RequestCallback() {

						@Override
						public void onResponseReceived(Request request, Response response) {
							// TODO Auto-generated method stub
							html.setHTML(response.getText());
						}

						@Override
						public void onError(Request request, Throwable exception) {
							// TODO Auto-generated method stub
							html.setHTML(exception.getMessage());
						}
					});
				} catch (RequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		addPersonBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Supprime l'existant
				html.setText("<form role='form' id='form'>"
                            +"<div class='form-group'>"
                            +"<label class='control-label' for='firstName'>Prénom</label>"
                            +"<input class='form-control' id='firstName' name='firstName'>"
                            +"</div>"
							+"<div class='form-group'>"
                            +"<label class='control-label' for='lastName'>Nom</label>"
                            +"<input class='form-control' id='lastName' name='lastName'>"
                            +"</div>"
							+"<div class='form-group'>"
                            +"<label class='control-label' for='gender'>Genre</label>"
                            +"<select id='gender' class='form-control' name='gender'>"
							+"<option>Homme</option>"
							+"<option>Femme</option>"
							+"</select>"
                            +"</div>"
							+"<div class='form-group'>"
                            +"<label class='control-label' for='email'>E-mail</label>"
                            +"<input class='form-control' id='email' type='email' name='email'>"
                            +"</div>"
							+"<div class='form-group'>"
                            +"<label class='control-label' for='birthday'>Date de naissance</label>"
                            +"<input class='form-control' id='birthday' type='date' name='birthday'>"
                            +"</div>"
							+"<div class='form-group'>"
                            +"<label class='control-label' for='fbProfil'>Facebook</label>"
                            +"<input class='form-control' id='fbProfil' name='fbProfil'>"
                            +"</div>"
                            +"<p id='submitPersonBtnContainer'></p>"
                        	+"</form>");
				RootPanel.get("submitPersonBtnContainer").add(submitPersonBtn);
			}
		});
		
		submitPersonBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			
			String url = "http://localhost:8080/rest/persons/add";
			
			InputElement fn = (InputElement) (Element) DOM.getElementById("firstName");
			InputElement ln = (InputElement) (Element) DOM.getElementById("lastName");
			InputElement g = (InputElement) (Element) DOM.getElementById("gender");
			InputElement e = (InputElement) (Element) DOM.getElementById("email");
			InputElement b = (InputElement) (Element) DOM.getElementById("birthday");
			InputElement f = (InputElement) (Element) DOM.getElementById("fbProfil");
			
			String requestData = "{ 'firstName': "+fn.getValue() +", 'lastName': "+ln.getValue() +",'gender': "+g.getValue() 
					+",'email': "+e.getValue() +",'birthday': "+b.getValue() +",'fbProfil': "+f.getValue() +"}";
			
			RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
			builder.setHeader("Content-Type", "application/json");

				try {
					Request response = builder.sendRequest(requestData, new RequestCallback() {
						
						@Override
						public void onResponseReceived(Request request, Response response) {
							// TODO Auto-generated method stub
							html.setHTML(response.getText());
						}

						@Override
						public void onError(Request request, Throwable exception) {
							// TODO Auto-generated method stub
							html.setHTML(exception.getMessage());
						}
					});
				} catch (RequestException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		homesBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Supprime l'existant
				html.setText("");
				
				String url = "http://localhost:8080/rest/homes/";
				
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
				builder.setHeader("Content-type", "application/json");
				try {
					Request response = builder.sendRequest(null, new RequestCallback() {

						@Override
						public void onResponseReceived(Request request, Response response) {
							// TODO Auto-generated method stub
							html.setHTML(response.getText());
						}

						@Override
						public void onError(Request request, Throwable exception) {
							// TODO Auto-generated method stub
							html.setHTML(exception.getMessage());
						}
					});
				} catch (RequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		devicesBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Supprime l'existant
				html.setText("");
				
				String url = "http://localhost:8080/rest/devices/";
				
				RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
				builder.setHeader("Content-type", "application/json");
				try {
					Request response = builder.sendRequest(null, new RequestCallback() {

						@Override
						public void onResponseReceived(Request request, Response response) {
							// TODO Auto-generated method stub
							html.setHTML(response.getText());
						}

						@Override
						public void onError(Request request, Throwable exception) {
							// TODO Auto-generated method stub
							html.setHTML(exception.getMessage());
						}
					});
				} catch (RequestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}

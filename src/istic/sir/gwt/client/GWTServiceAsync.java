package istic.sir.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GWTServiceAsync {

	void gwtServer(String name, AsyncCallback<String> callback);

}

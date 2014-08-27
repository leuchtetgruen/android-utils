package de.leuchtetgruen.streetnav;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class SimpleFusedLocationListener implements GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener, LocationListener {

	
	private LocationClient locationClient;
	private List<LocationListener> locationListeners;
	
	public SimpleFusedLocationListener(Activity act, LocationListener locListener) {
		locationListeners = new ArrayList<LocationListener>();
		
		addLocationListener(locListener);
		
		
		int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(act);
		if (result!=ConnectionResult.SUCCESS) {
			GooglePlayServicesUtil.getErrorDialog(result, act, 1).show();
			return;
		}
		
		locationClient = new LocationClient(act, this, this);
		locationClient.connect();
		
		
	}
	
	public void addLocationListener(LocationListener l) {
		locationListeners.add(l);
	}
	
	/**
	 * You really should not use it as it will not accuratly provide
	 * you with a good location.
	 * 
	 * @return
	 */
	public Location getLastKnownLocation() {
		return locationClient.getLastLocation();
	}



	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		LocationRequest request = LocationRequest.create();
		// Use high accuracy
		request.setPriority(
				LocationRequest.PRIORITY_HIGH_ACCURACY);
		// Set the update interval to 5 seconds
		request.setInterval(5);
		// Set the fastest update interval to 1 second
		request.setFastestInterval(1);

		
		locationClient.requestLocationUpdates(request, this);
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLocationChanged(Location arg0) {
		for (LocationListener locListener : locationListeners) {
			locListener.onLocationChanged(arg0);
		}
	}
}

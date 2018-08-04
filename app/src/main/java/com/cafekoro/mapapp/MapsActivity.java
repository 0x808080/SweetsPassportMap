package com.cafekoro.mapapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

	private final int MAX_MAP_MARKER = 9;                           /**< マーカーの数 */
	private GoogleMap mMap;                                         /**< googleMap */
	private MapMarker[] mapMarker = new MapMarker[MAX_MAP_MARKER];  /**< マーカーの座標 */


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);

		initMapMarker();

		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}


	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;

		for( int i = 0; i < MAX_MAP_MARKER; i++ ){
			MapMarker marker = mapMarker[i];
			LatLng sydney = new LatLng(marker.GetX(), marker.GetY());
			mMap.addMarker(new MarkerOptions().position(sydney).title(marker.GetName()));
		}

		//mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
	}

	/**---------------------------------------------------------------------------------------------
	 * マーカーの初期化
	 *--------------------------------------------------------------------------------------------*/
	private void initMapMarker() {

		for( int i = 0; i < MAX_MAP_MARKER; i++ ) {
			String name = MapData[i][2];
			float x = Float.parseFloat(MapData[i][0]);
			float y = Float.parseFloat(MapData[i][1]);
			mapMarker[i] = new MapMarker(name, x, y);
		}
	}

	/**
	 * マーカー座標のクラス
	 */
	public class MapMarker {
		private String _name;
		private float _x;
		private float _y;

		MapMarker(String name, float x, float y) {
			_name = name;
			_x = x;
			_y = y;
		}

		public String GetName() {
			return _name;
		}

		public  float GetX() {
			return _x;
		}

		public float GetY() {
			return _y;
		}
	}


	private String[][] MapData = {
			{ "38.243593", "140.319377", "コッペdeサンド" },
			{ "38.288123", "140.321372", "TENN." },
			{ "38.26259179", "140.32843702", "FIN'S", },
			{ "38.248241", "140.338755", "maison de ble'" },
			{ "37.90498214", "140.126192", "安田製パン所" },			// ここから上は不確定情報
			{ "38.380743", "140.263422", "パンのコマチ 寒河江店"},
			{ "00.000000", "000.000000", "ぱん工房 obata"},
			{ "38.576873", "140.383165", "米粉パンのお店 あおいそら"},
			{ "38.107174", "140.037502", "木村家本店"},				// ここまでパン
	};
}







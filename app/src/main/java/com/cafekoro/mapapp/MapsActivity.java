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
            LatLng sydney = new LatLng(marker.x, marker.y);
            mMap.addMarker(new MarkerOptions().position(sydney).title(marker.name));
        }

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    /**
     * マーカーの初期化
     */
    private void initMapMarker() {

        for( int i = 0; i < MAX_MAP_MARKER; i++ ) {
            mapMarker[i] = new MapMarker();
            mapMarker[i].name = Name[i];
            mapMarker[i].x = point[i][0];
            mapMarker[i].y = point[i][1];
        }
    }

    /**
     * マーカー座標のクラス
     */
    public class MapMarker {
        public String name;
        public float x;
        public float y;
    }


    private String[] Name = {
            "コッペdeサンド",
            "TENN.",
            "FIN'S",
            "maison de ble'",
            "安田製パン所",
            "パンのコマチ 寒河江店",
            "ぱん工房 obata",
            "米粉パンのお店 あおいそら",
            "木村家本店",

            "--",
            "--",
    };

    private float[][] point = {
            { (float) 38.243593, (float) 140.319377 },
            { (float) 38.288123, (float) 140.321372 },
            { (float) 38.26259179, (float) 140.32843702 },
            { (float) 38.248241, (float) 140.338755 },
            { (float) 37.90498214, (float) 140.126192 },    // ここから上は不確定情報
            { (float) 38.380743, (float) 140.263422 },
            { (float) 00.000000, (float) 000.000000 },
            { (float) 38.576873, (float) 140.383165 },
            { (float) 38.107174, (float) 140.037502 },      // ここまでパン

            { (float) 00.000000, (float) 000.000000 },
            { (float) 00.000000, (float) 000.000000 },
            { (float) 00.000000, (float) 000.000000 },
    };
}







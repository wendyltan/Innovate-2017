package com.topcoder.innovate.innovate2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.topcoder.innovate.innovate2017.model.Map;
import com.topcoder.innovate.innovate2017.util.DataRetriever;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private MapView mMapView = null;

    private BaiduMap bdMap;

    private List<Map> mapPosData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map);
        mMapView = (MapView) findViewById(R.id.map_view);

        bdMap = mMapView.getMap();
        bdMap.setMyLocationEnabled(true);

        //普通地图
        bdMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        LatLng origin = new LatLng(37.783753,-122.401192);
        MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(origin, 16);   //设置地图中心点以及缩放级别
        bdMap.animateMapStatus(u);

        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.u);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions().position(origin).icon(bitmap).draggable(true);
        //在地图上添加Marker，并显示
        bdMap.addOverlay(option);

        mapPosData = new DataRetriever().retrieveAllPositions(this);
        showMarkers(mapPosData);


    }
    private void showMarkers(List<Map> mapList){
        for (Map map :mapList){
            //定义Maker坐标点
            LatLng point = new LatLng(map.getLatitude(),map.getLongitude());
            //构建Marker图标
            BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.u);
            //构建MarkerOption，用于在地图上添加Marker
            OverlayOptions option = new MarkerOptions().position(point).icon(bitmap).draggable(true);
            //在地图上添加Marker，并显示
            bdMap.addOverlay(option);


        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();

        bdMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng position = marker.getPosition();
                for (Map map : mapPosData){
                    LatLng Jposition = new LatLng(map.getLatitude(),map.getLongitude());
                    if (Jposition.latitude == position.latitude&&Jposition.longitude==position.longitude){
                        Toast.makeText(getApplicationContext(),map.getName()+","+map.getAddress(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                Toast.makeText(getApplicationContext(),"this is center point of the map",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        MapView.setMapCustomEnable(false);
        mMapView = null;
    }
}

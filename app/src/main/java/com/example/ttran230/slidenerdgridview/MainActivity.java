package com.example.ttran230.slidenerdgridview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by ttran230 on 7/14/2016.
 */


public class MainActivity extends Activity{
//    1 prepare data source [images in drawable & countryName in string.xml]
//    2 create a GridView in XML[main in layout file]
//    3 Bring GridView from XML to java [to fill values]
//    4 Create your adapter that extends BaseAdapter
//    5 This adapter expects you to maintain any array having all the data
//    6 Fill the array inside the constructor of your adapter
//    a) create a class SingeItem that contains the ImageID and country name of a single item
//    b) maintain an ArrayList that stores SingleItem objects
//    c) get the value of country names and image Ids from drawable folder and put them insdide this ArrayList
//    7 define the structure of a single block inside the GrideView(single_item.xml)
    GridView myGridView;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGridView = (GridView) findViewById(R.id.gridView);
    }
}
class Country{
    int imageId;
    String countryName;
    Country(int imageId, String countryName){
        this.imageId = imageId;
        this.countryName = countryName;
    }

}

class  VivzAdapter extends BaseAdapter {

    ArrayList<Country> listCountry ;
    VivzAdapter(Context context){
        listCountry = new ArrayList<Country>();
        Resources resource = context.getResources();

        //to do : get resources suck like java.
        String[] tempCountryName = resource.getStringArray(R.array.country_name);
        int[] countryImages = {R.drawable.Germany,R.drawable.Vietname,R.drawable.Japan,R.drawable.USA,R.drawable.England,
                R.drawable.China,R.drawable.Korean} ;

        for(int i = 0; i< 10;i++){
            Country tempCountry = new Country(countryImages[i], tempCountryName[i]);
            listCountry.add(tempCountry);
        }
    };
    @Override
    public int getCount() {
        return listCountry.size();
    }

    @Override
    public Object getItem(int position) {
        return listCountry.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        ImageView myCountry;
        ViewHolder(View v){
            myCountry = (ImageView) v.findViewById(R.id.imageView);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}

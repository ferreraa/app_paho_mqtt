package paho.mqtt.java.example;

import android.graphics.Point;

//import com.google.android.gms.maps.model.LatLng;

/**
 * Created by romane on 23/03/17.
 */

public class Message {
    private String id;
    private Point coord;

    public Message(){};
    public Message(String id, Point coord){
        this.id=id;
        this.coord=coord;
    }
    public Message(String s){
        String[] tab=s.split(":");
        id=tab[0];
        coord= new Point(Integer.valueOf(tab[1]),Integer.valueOf(tab[2]));
    }
    public void setId (String id){
        this.id=id;
    }

    public void setPoint(Point point){
        this.coord=point;
    }

    public String getId (){
        return id;
    }
    public Point getPoint(){
        return coord;
    }

    public String toString (){
        return id+":"+coord.x+":"+coord.y;
    }



}

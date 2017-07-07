package ChampCDImg;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Champions {
    String nom;
    float [] A;
    float [] Z;
    float [] E;
    float [] R;
    String picture;
    Icon iP;
    Icon iQ;
    Icon iW;
    Icon iE;
    Icon iR;
    public Champions(String s,float [] A,float [] Z,float [] E,float [] R,String picture){
        nom = s;
        this.A=A;
        this.Z=Z;
        this.E=E;
        this.R=R;
        this.picture=picture;

    }

    public Champions(String s, float [] A, float [] Z, float [] E, float [] R, String picture, Icon iP, Icon iQ,Icon iW,Icon iE,Icon iR){
        nom = s;
        this.A=A;
        this.Z=Z;
        this.E=E;
        this.R=R;
        this.picture=picture;
        this.iP=iP;
        this.iQ=iQ;
        this.iW=iW;
        this.iE=iE;
        this.iR=iR;

    }
    public Icon getiP(){
        return iP;
    }
    public Icon getiQ(){
        return iQ;
    }
    public Icon getiW(){
        return iW;
    }
    public Icon getiE(){
        return iE;
    }
    public Icon getiR(){
        return iR;
    }

    public float getA(int j){
        return A[j-1];}
    public float getZ(int j){
        return Z[j-1];}
    public float getE(int j){
        return E[j-1];}
    public float getR(int j){
        return R[j-1];

    }
    public String  getPicture(){
        return picture;
    }
    public String toString(){
        String s="";
        s+=nom;
        s+="\n";
        for (int i = 0; i < 5; i++)
            s+=A[i] + " " + Z[i] + " " + " " + E[i] + " " + R[i]+"\n";
        return s;
    }
}

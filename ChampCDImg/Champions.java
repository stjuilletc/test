package ChampCDImg;

import java.awt.image.BufferedImage;

public class Champions {
    String nom;
    float [] A;
    float [] Z;
    float [] E;
    float [] R;
    String picture;
    public Champions(String s,float [] A,float [] Z,float [] E,float [] R,String picture){
        nom = s;
        this.A=A;
        this.Z=Z;
        this.E=E;
        this.R=R;
        this.picture=picture;

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
}

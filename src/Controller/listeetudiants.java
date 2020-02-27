/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author nada kd
 */
 public  class listeetudiants {

    

  private String A;
    private String B;

    private String C;

    private int D;

    private String E;

    private String F;
  
    private String G;

    public listeetudiants(String A, String B, String C, int D, String E, String F, String G) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
        this.F = F;
        this.G = G;
    }

   

    listeetudiants() {}
  

    public String getA() {
        return A;
    }

    public String getB() {
        return B;
    }

    public String getC() {
        return C;
    }

    public int getD() {
        return D;
    }

    public String getE() {
        return E;
    }

    public String getF() {
        return F;
    }

    public String getG() {
        return G;
    }

    public void setA(String A) {
        this.A = A;
    }

    public void setB(String B) {
        this.B = B;
    }

    public void setC(String C) {
        this.C = C;
    }

    public void setD(int D) {
        this.D = D;
    }

    public void setE(String E) {
        this.E = E;
    }

    public void setF(String F) {
        this.F = F;
    }

    public void setG(String G) {
        this.G = G;
    }
              
 @Override
    public String toString() {
        return "listeetudiants{" + "A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", E=" + E + ", F=" + F + ", G=" + G + '}';
    }
    
}

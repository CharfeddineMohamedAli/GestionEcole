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
  public  class listeetudiantsO {

  private String A;
    private String B;

    private String C;

    private String D;

    private int E;

    private String F;
  
    private String G;

    
    public listeetudiantsO(String A, String B, String C, String D, int E) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.E = E;
    
    }

    @Override
    public String toString() {
        return "listeetudiants{" + "A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + ", E=" + E + '}';
    }

   

    
    listeetudiantsO() {}
  

    public String getA() {
        return A;
    }

    public String getB() {
        return B;
    }

    public String getC() {
        return C;
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

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }

    public int getE() {
        return E;
    }

    public void setE(int E) {
        this.E = E;
    }

    

    public void setF(String F) {
        this.F = F;
    }

    public void setG(String G) {
        this.G = G;
    }
              

    
}

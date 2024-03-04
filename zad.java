import java.util.ArrayList;

class zad {
    String nazwa;
    double netto, vat;

    public zad(String nazwa, double netto, double vat) {
        this.nazwa = nazwa;
        this.netto = netto;
        this.vat = vat;
    }

    public static void main(String[] args) {
        ArrayList<zad> paragon = new ArrayList<>();

        double sumNetto8 = 0;
        double sumNetto23 = 0;
        double sumVAT8 = 0;
        double sumVAT23 = 0;
        double sumNetto = 0;
        
        paragon.add(new zad("Clean Code, Robert C. Martin", 100.00, 8));
        paragon.add(new zad("Applying UML and Patterns, C. Larman", 300.00, 8));
        paragon.add(new zad("Shipping", 50.00, 23));

        
        for (zad produkt : paragon) {
            sumNetto += produkt.netto;
            if (produkt.vat == 8) {
                sumNetto8 += produkt.netto;
                sumVAT8 += produkt.netto * 0.08;

            } else if (produkt.vat == 23) {
                sumNetto23 += produkt.netto;
                sumVAT23 += produkt.netto * 0.23;
            }
        }

        System.out.printf("|               | Total netto  |   %,.2f  |\n",sumNetto);
        System.out.println("|---------------|--------------|-----------|");
        System.out.printf("| VAT 8%%        |    %,.2f    |    %,.2f  |\n", sumNetto8, sumVAT8);
        System.out.printf("| VAT 23%%       |    %,.2f     |    %,.2f  |\n", sumNetto23, sumVAT23);
    }
}
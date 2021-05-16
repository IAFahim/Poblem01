interface PayableTax{
    public static int TAXPERCENTAGE = 15;
    double yearlyTaxfreeIncome();
    double yearlyTaxableIncome();
    double getIncomeTax();
}
class Employee extends Salary implements PayableTax {
    private String Name;
    private String Gender;
    private String NID;
    private String TIN;
    private double MonthlySalary;

    public Employee(String name, String gender, String nid, String tin) {
        Name = name;
        Gender = gender;
        NID = nid;
        TIN = tin;
    }

    public String getName() {
        return Name;
    }

    public String getGender() {
        return Gender;
    }

    public String getNID() {
        return NID;
    }

    public String getTIN() {
        return TIN;
    }

    public String toString() {
        return "Employee [Name=" + Name + ", Gender=" + Gender + ", NID=" + NID + ", TIN=" + TIN + ", MonthlySalary="
                + MonthlySalary + "]";
    }

    public void setMonthlySalary(double amount) {
        MonthlySalary = amount;
    }

    public double yearlyTaxfreeIncome() {
        String g = "Male";
        double maleTaxStartsAfter = 300000;
        double femaleTaxStartsAfter = 450000;
        double yearlyNetIncome=yearlyNetIncome();
        if (getGender().equalsIgnoreCase(g)) {
            if (maleTaxStartsAfter < yearlyNetIncome) {
                return maleTaxStartsAfter;
            }
        } else {
            if (femaleTaxStartsAfter < yearlyNetIncome()) {
                return femaleTaxStartsAfter;
            }
        }
        return yearlyNetIncome;
    }

    public double yearlyTaxableIncome() {
        return yearlyNetIncome() - yearlyTaxfreeIncome();
    }

    public double getIncomeTax() {
        return yearlyTaxableIncome() * (TAXPERCENTAGE / 100.0);
    }

    public double yearlySalary() {
        return MonthlySalary * 12.0;
    }

    public double yearlyBonus() {
        return MonthlySalary * 2.0;
    }

    public double yearlyNetIncome() {
        return yearlySalary() + yearlyBonus();
    }

}



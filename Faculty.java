class Faculty extends Employee{
    private double basicSalary;
    private double allowance;

    public Faculty(String name, String gender, String nid, String tin, double basic) {
        super(name, gender, nid, tin);
        basicSalary = basic;
        setAllowance();
        setMonthlySalary(basicSalary+allowance);
    }

    public void setAllowance() {
        allowance = basicSalary*0.5;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public String toString() {
        return "Faculty [basicSalary=" + basicSalary + ", allowance=" + allowance + "]";
    }

}

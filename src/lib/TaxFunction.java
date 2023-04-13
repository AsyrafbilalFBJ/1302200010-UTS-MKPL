package lib;

public class TaxFunction {
	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	private static final int SINGLE_EMPLOYEE = 54000000;
        private static final int MARRIED_EMPLOYEE = 58500000;
        private static final int EMPLOYEE_CHILD = 1500000;
        private static final double TAX_RATE = 0.05;

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		int taxExemption = isMarried ? MARRIED_EMPLOYEE : SINGLE_EMPLOYEE;
                if (numberOfChildren > 3) {
                    taxExemption += 3 * EMPLOYEE_CHILD;
                } else {
                    taxExemption += numberOfChildren * EMPLOYEE_CHILD;
                }

		tax = (int) Math.round(TAX_RATE * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - taxExemption));
		
		if (tax < 0) {
			return 0;
		} else {
			return tax;
		} 
	}
	
}

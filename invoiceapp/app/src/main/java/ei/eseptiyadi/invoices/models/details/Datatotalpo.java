package ei.eseptiyadi.invoices.models.details;

import com.google.gson.annotations.SerializedName;

public class Datatotalpo{

	@SerializedName("totalbayar")
	private int totalbayar;

	@SerializedName("subtotal")
	private int subtotal;

	@SerializedName("angkir")
	private int angkir;

	@SerializedName("ppn")
	private int ppn;

	public void setTotalbayar(int totalbayar){
		this.totalbayar = totalbayar;
	}

	public int getTotalbayar(){
		return totalbayar;
	}

	public void setSubtotal(int subtotal){
		this.subtotal = subtotal;
	}

	public int getSubtotal(){
		return subtotal;
	}

	public void setAngkir(int angkir){
		this.angkir = angkir;
	}

	public int getAngkir(){
		return angkir;
	}

	public void setPpn(int ppn){
		this.ppn = ppn;
	}

	public int getPpn(){
		return ppn;
	}

	@Override
 	public String toString(){
		return 
			"Datatotalpo{" + 
			"totalbayar = '" + totalbayar + '\'' + 
			",subtotal = '" + subtotal + '\'' + 
			",angkir = '" + angkir + '\'' + 
			",ppn = '" + ppn + '\'' + 
			"}";
		}
}
package model;

public class Products {

	private int product_ID;
	private String product_name;
	private float product_price;
	private int product_qty;

	public int getProduct_ID() {
		return product_ID;
	}

	@Override
	public String toString() {
		return "Products [product_ID=" + product_ID + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_qty=" + product_qty + "]";
	}

	public Products() {

	}

	public Products(int product_ID, String product_name, float product_price, short product_qty, float product_total) {
		super();
		this.product_ID = product_ID;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_qty = product_qty;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getProduct_price() {
		return product_price;
	}

	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}

	public int getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(short product_qty) {
		this.product_qty = product_qty;
	}

}

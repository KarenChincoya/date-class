
public class Fecha {
	private Integer dia;
	private Integer mes;
	private Integer anio;
	
	//declarar setters & getter
	
	public void setDia(Integer d){
		dia = d;
	}
	
	public Integer getDia(){
		return dia;
	}
	
	public void setMes(Integer m) {
		mes = m;
	}
	
	public Integer getMes() {
		return mes;
	}
	
	public void setAnio(Integer a) {
		anio = a;
	}
	
	public Integer getAnio() {
		return anio;
	}
	
	public void aumentarUnDia() {
		Integer []k = new Integer[3];
		k[0] = dia;
		k[1] = mes;
		k[2] = anio;
		k = sumarUnDia(k);
		System.out.println("Fecha siguiente: "+k[0]+"/"+k[1]+"/"+k[2]);
	}
	
	public void disminuirUnDia(){
		Integer []k = new Integer[3];
		k[0] = dia;
		k[1] = mes;
		k[2] = anio;
		k = restarUnDia(k);
		System.out.println("Fecha anterior: "+k[0]+"/"+k[1]+"/"+k[2]);
	}
	
	public void aumentarNDias(Integer n ) {
		Integer []k = new Integer[3];
		k[0] = dia;
		k[1] = mes;
		k[2] = anio;
		for(int i=0;i<n;i++) {
			k = sumarUnDia(k);
		}
		System.out.println("Fecha dentro de "+n +" dias: "+k[0]+"/"+k[1]+"/"+k[2]);
	}
	
	public void disminuirNDias(Integer n ) {
		Integer []k = new Integer[3];
		k[0] = dia;
		k[1] = mes;
		k[2] = anio;
		for(int i=0;i<n;i++) {
			k = restarUnDia(k);
		}
		System.out.println("Fecha hace "+n +" dias: "+k[0]+"/"+k[1]+"/"+k[2]);
	}
	
	private Integer limitDay(Integer month) {
		Integer dl;
		if(month==2) {
			if((anio%4) == 0)
				dl = 29; //si es bisiesto tiene 29 dias 
			else
				dl = 28;
		}else if(month==4 || month==6 || month==9 || month==11) {
			dl = 30;
		}else dl=31;
		return dl; //dias limite
	}
	
	//metodo sumarUnDia
	private Integer[] sumarUnDia(Integer k[]){
		Integer diaLimite;
		Integer [] f = new Integer[3]; //f de fecha
		Integer d,m,a;
		d = k[0];
		m = k[1];
		a = k[2];
		diaLimite = limitDay(m);
		
		//a partir del limite:
		if((d+1)<=diaLimite) {//suma normal, un dia
			f[0] = d+1;
			f[1] = m;
			f[2] = a;
		}else {//se debe cambiar el mes
			if(m+1<=12) {
				f[0] = 1;
				f[1] = m+1;
				f[2] = a;
			}else {
				f[0] = 01;
				f[1] = 01;
				f[2] = a + 1;
			}
		}
		return f;
	}
	
	private Integer[] restarUnDia(Integer k[]) {
		Integer []f = new Integer[3];
		Integer d,m,a;
		d = k[0];
		m = k[1];
		a = k[2];
		//a partir del cero
		if((d-1)>=1) {//suma normal, un dia
			f[0] = d-1;
			f[1] = m;
			f[2] = a;
		}else {//se debe cambiar el mes
			if(m-1>=1) {
				f[0] = limitDay(m-1); //debe imprimir el ultimo dia del mes (mes-1) el ultimo
				f[1] = m-1;
				f[2] = a;
			}else {
				f[0] = 31;
				f[1] = 12;
				f[2] = a-1;
			}
		}
		return f;
	}
		
}

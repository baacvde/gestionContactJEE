package model;


public class Contact {
	private String nom ;
	private String prenom;
	private String email;
	private String telephone;
	private int age;
	
	public Contact(String nom, String prenom, String email, String telephone, int age) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setTelephone(telephone);
		this.setAge(age);
		
		
	}


	


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setAge(int age) {
		this.age = age;
		
	}
	public int getAge() {
		return age;
		
	}

	
	public String toString() {
        return "Contact {" +
               "Nom='" + nom + '\'' +
               ", Prenom='" + prenom + '\'' +
               ", Email='" + email + '\'' +
               ", Telephone='" + telephone + '\'' +
               ",Age='" + age + '\''+
               '}';
    }


	
	

	
	}

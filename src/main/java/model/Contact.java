package model;


public class Contact {
	
	private int id;


	private String nom ;
	private String prenom;


	private String email;
	private String telephone;
	private int age;


	public Contact(int id, String nom, String prenom, String email, String telephone, int age) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
	}


	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
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

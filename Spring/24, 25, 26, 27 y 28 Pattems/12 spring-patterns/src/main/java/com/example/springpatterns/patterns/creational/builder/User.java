package com.example.springpatterns.patterns.creational.builder;

// puedo usar el plugins Desing patterns
public class User {

	// atributos
	private Long id; // puede ser nulo (clase envoltorio Long)
	private String firstName;
	private String lastName;
	private String email;
	private Boolean married;

	// constructores
	public User(Long id, String firstName, String lastName, String email, Boolean married) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.married = married;
	}

	// getter y setter

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	/**
	 * CLASE BUILDER
	 */
	// Una clase static (que pertenece a la clase) para que pueda poner User.Builder sin tener que haber creado un objeto User primero, es decir que con User.Builder puedo acceder
	// a la clase Builder sin necesidad de haber creado primero un User
	public static class Builder {

		//atributos iguales a User
		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private Boolean married;

		// Se encarga de crear el objeto User, Build es el metodo que se va a invocar al final de todo
		User build() {
			// En caso de necesitar obligar a rellenar ciertas propiedades
//			if(this.id == null || this.email == null)
//				throws FieldsMandatory();
			return new User(this.id, this.firstName, this.lastName, this.email, this.married);
		}

		// Metodos GETTER
		public Long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getEmail() {
			return email;
		}

		public Boolean getMarried() {
			return married;
		}

		// Metodos SETTER estilo FLuent, retornando this (aqui comienza la magia)
		public Builder setId(Long id) {
			this.id = id;
			return this; //al retornar this lo que permite es concatenar un metodo a otro, al hacer setid ese retunr this me devuelve a ese mismo objeto por lo que puedo aplicarle
			//otro sett como ser setFirstName luego otro sett como setLastName etc, cosa que con un sett normal no puedo hacer esto
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setMarried(Boolean married) {
			this.married = married;
			return this;
		}

	}

}

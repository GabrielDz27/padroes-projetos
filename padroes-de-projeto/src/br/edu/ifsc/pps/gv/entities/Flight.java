package br.edu.ifsc.pps.gv.entities;

import br.edu.ifsc.pps.gv.exceptions.InvalidEntityException;

public class Flight extends AbstractDbEntity {
	private String number;
	private String company;
	private String from;
	private String to;
	private Integer capacity;
	
	public Flight() {
		
	}
	
	@Override
	public void doSave() throws InvalidEntityException {
		super.doSave();
		
		if (this.from.isBlank()) {
			throw new InvalidEntityException("É necessário definir um local de partida.");
		}
		
		if (this.to.isBlank()) {
			throw new InvalidEntityException("É necessário definir um destino.");
		}
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Voo " + number + " (" + company + ") | Origem: " + from + " -> Destino: " + to + " | Cap: " + capacity;
	}
	
	public static class Builder {
		private final Flight flight;
		
		public Builder() {
			this.flight = new Flight();
		}
		
		public Builder withNumber(String number) {
			this.flight.setNumber(number);
			return this;
		}
		
		public Builder withFrom(String from) {
			this.flight.setFrom(from);
			return this;
		}
		
		public Builder withTo(String to) {
			this.flight.setTo(to);
			return this;
		}
		
		public Builder withCompany(String company) {
			this.flight.setCompany(company);
			return this;
		}

		public Builder withCapacity(int capacity) {
			this.flight.setCapacity(capacity);
			return this;
		}
		
		public Flight build() {
			return this.flight;
		}
	}
}

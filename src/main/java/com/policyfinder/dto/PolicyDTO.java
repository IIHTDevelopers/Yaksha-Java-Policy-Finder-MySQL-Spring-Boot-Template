package com.policyfinder.dto;

public class PolicyDTO {
	private Long id;

	private String name;

	private Integer tenure; // Tenure in months

	private Double amount;

	private Double interestRate;

	private String coverage;

	public PolicyDTO() {
		super();
	}

	public PolicyDTO(Long id, String name, Integer tenure, Double amount, Double interestRate, String coverage) {
		super();
		this.id = id;
		this.name = name;
		this.tenure = tenure;
		this.amount = amount;
		this.interestRate = interestRate;
		this.coverage = coverage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	@Override
	public String toString() {
		return "PolicyDTO [id=" + id + ", name=" + name + ", tenure=" + tenure + ", amount=" + amount
				+ ", interestRate=" + interestRate + ", coverage=" + coverage + "]";
	}
}

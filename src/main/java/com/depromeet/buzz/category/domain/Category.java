package com.depromeet.buzz.category.domain;

import com.depromeet.buzz.common.domain.BasicEntity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	private Category() { }

	public Category(String name) {
		if(Objects.isNull(name) || name.trim().isEmpty()) {
			throw new IllegalArgumentException("category name is empty");
		}

		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Category category = (Category)o;
		return id.equals(category.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "Category{" +
			"id=" + id +
			", name='" + name + '\'' +
			'}';
	}

}

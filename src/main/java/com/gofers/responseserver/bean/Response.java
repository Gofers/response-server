package com.gofers.responseserver.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fangzongzhou
 */
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
	@Id
	@GeneratedValue
	private int id;

	@Column
	private int requestId;

	@Column
	private String response;
}

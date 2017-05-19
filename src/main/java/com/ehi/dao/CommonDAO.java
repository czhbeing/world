package com.ehi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class CommonDAO {
	@Autowired
	private JdbcTemplate devJdbc;

	@Autowired
	private JdbcTemplate qaJdbc;

	private static String sql = "select distinct network_name from pv_network";

	public String getNetwork() {
		List<String> strs = devJdbc.queryForList(sql, String.class);
		return strs.toString();
	}

	public String getNetwork2() {
		List<String> strs = qaJdbc.queryForList(sql, String.class);
		return strs.toString();

	}

}

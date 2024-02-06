package com.trg.oracle.springjdbcapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductUtilImpl implements ProductUtil {

	JdbcTemplate template;

	public ProductUtilImpl() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		template = new JdbcTemplate(ds);
	}

	@Override
	public boolean save(Product p) {
		int pid = p.getProductId();
		String nm = p.getName();
		float pr = (float) p.getPrice();
		try {
			template.update("insert into product values(?,?,?)", pid, nm, pr);
			return true;
		} catch (DuplicateKeyException ex) {
			return false;
		}
	}

	@Override
	public void update(Product p) {

		int pid = p.getProductId();

		float prc = (float) p.getPrice();

		template.update("update product set price=? where productid = ?", prc, pid);

	}

	@Override
	public Product getProduct(int id) {

		try {
			Map<String, Object> row = template.queryForMap("select * from product where productid = ?", id);

			int pid = (Integer) row.get("productid");
			String pnm = (String) row.get("name");
			Float prc = (Float) row.get("price");

			Product p = new Product(pid, pnm, prc);
			return p;
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}

	}

	@Override
	public List<Product> getAll() {
		List<Map<String, Object>> list = template.queryForList("select * from product");

		ArrayList<Product> plist = new ArrayList<>();

		for (Map<String, Object> row : list) {

			int pid = (Integer) row.get("productid");
			String pnm = (String) row.get("name");
			Float prc = (Float) row.get("price");

			Product p = new Product(pid, pnm, prc);
			plist.add(p);
		}
		return plist;

	}

}

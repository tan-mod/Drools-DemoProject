package com.demo.runtime;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.demo.model.Product;

public class DroolsApp {

	public static final void main(String[] args) {
		try {

			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession ksession = kContainer.newKieSession("ksession-rules");

			Product p1 = new Product();
			p1.setType("gold");
			Product p2 = new Product();
			p2.setType("silver");

			System.out.println("**********BEFORE************");
			System.out.println("Product 1");
			System.out.println("Type = " + p1.getType() + ", Discount = " + p1.getDiscount());
			System.out.println("Product 2");
			System.out.println("Type = " + p2.getType() + ", Discount = " + p2.getDiscount());

			ksession.insert(p1);
			ksession.insert(p2);
			ksession.fireAllRules();
			ksession.dispose();

			System.out.println("\n**********AFTER************");
			System.out.println("Product 1");
			System.out.println("Type = " + p1.getType() + ", Discount = " + p1.getDiscount());
			System.out.println("Product 2");
			System.out.println("Type = " + p2.getType() + ", Discount = " + p2.getDiscount());

		} catch (Exception e) {
		}
	}
}
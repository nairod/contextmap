package ch.flask.contextmap.application;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Configuration
	@EnableNeo4jRepositories(basePackages = "contextmap")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("contextmap");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory().newEmbeddedDatabase("contextmap.db");
		}
	}


	public void run(String... args) throws Exception {

	
	

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}

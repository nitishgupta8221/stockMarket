package project.nitish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.nitish.model.StockPrice;

@Repository
public interface StockPriceDao extends JpaRepository<StockPrice, Integer> {

}

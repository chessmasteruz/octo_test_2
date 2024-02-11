package uz.rovshan.testtask2;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import uz.rovshan.testtask2.model.Card;
import uz.rovshan.testtask2.model.CardTransaction;
import uz.rovshan.testtask2.model.User;
import uz.rovshan.testtask2.repository.CardRepository;
import uz.rovshan.testtask2.repository.CardTransactionRepository;
import uz.rovshan.testtask2.repository.UserRepository;

import java.util.Date;

@Component
public class TestData {

    final UserRepository userRepo;

    final CardRepository cardRepo;

    final CardTransactionRepository transRepo;

    public TestData(UserRepository userRepo, CardRepository cardRepo, CardTransactionRepository transRepo) {
        this.userRepo = userRepo;
        this.cardRepo = cardRepo;
        this.transRepo = transRepo;
    }

    //Test Data insert
    @PostConstruct
    private void postConstruct() {
        //User 1
        User rovshan = new User();
        rovshan.setFio("Rovshan Makhsudov");
        rovshan.setPhone(998909948190L);
        rovshan.setDob(new Date());
        rovshan.setEmail("ravshan_mr@mail.ru");
        rovshan.setStatus(1);

        userRepo.save(rovshan);

        Card card1 = new Card();
        card1.setCardName("Rovshan's card");
        card1.setCardExpire("12/25");
        card1.setStatus(1);
        card1.setBalance(16250487L);
        card1.setCardType("hum");
        card1.setCardNumber("9860330115152020");
        card1.setUser(rovshan);

        cardRepo.save(card1);

        CardTransaction trans1 = new CardTransaction();

        Long balance = card1.getBalance();
        Long amount = 3000L;

        trans1.setUser(rovshan);
        trans1.setCard(card1);
        trans1.setType("credit");
        trans1.setAmount(amount);
        trans1.setOld_balance(balance);
        trans1.setNew_balance(balance - amount);
        card1.setBalance(trans1.getNew_balance());

        transRepo.save(trans1);

        CardTransaction trans2 = new CardTransaction();

        balance = card1.getBalance();
        amount = 50000L;

        trans2.setUser(rovshan);
        trans2.setCard(card1);
        trans2.setType("debit");
        trans2.setAmount(amount);
        trans2.setOld_balance(balance);
        trans2.setNew_balance(balance + amount);
        card1.setBalance(trans1.getNew_balance());

        transRepo.save(trans2);
        cardRepo.save(card1);


        //User 2
        User peter = new User();
        peter.setFio("Peter Parker");
        peter.setPhone(998947778190L);
        peter.setDob(new Date());
        peter.setEmail("peter.p@gmail.com");
        peter.setStatus(1);

        userRepo.save(peter);

        Card card2 = new Card();
        card2.setCardName("Peter's card");
        card2.setCardExpire("08/26");
        card2.setStatus(1);
        card2.setBalance(14255487L);
        card2.setCardType("uz");
        card2.setCardNumber("8600330115151111");
        card2.setUser(peter);

        cardRepo.save(card2);

        CardTransaction trans3 = new CardTransaction();

        balance = card2.getBalance();
        amount = 14000L;

        trans3.setUser(peter);
        trans3.setCard(card2);
        trans3.setType("credit");
        trans3.setAmount(amount);
        trans3.setOld_balance(balance);
        trans3.setNew_balance(balance - amount);
        card2.setBalance(trans3.getNew_balance());

        transRepo.save(trans3);
        cardRepo.save(card2);
    }
}

package BlackJack.view;

public interface IView
{
  void DisplayWelcomeMessage();
  Input GetInput();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) throws InterruptedException;
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) throws InterruptedException;
  void DisplayGameOver(boolean a_dealerIsWinner);
}
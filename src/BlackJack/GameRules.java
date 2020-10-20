package BlackJack;

public class GameRules {

    /**
     **************************************BlackJack Console**********************************************
     *
     * Game Rules:
     *            - CARDS = {2,3,4,5,6,7,8,9,10,J,Q,K,A}
     *            - SUITS = {CLUBS, DIAMONDS, SPADES, HEARTS}
     *            - each card has 4 suits - "2 CLUBS", "2 DIAMONDS"
     *                                                "2 SPADES", "2 HEARTS"
     *
     *            - 13 cards, each have 4 suits total 52 cards in a DECK
     *
     *            - The value of each card is the number, except if it is J Q K,
     *            - then the value of that card is 10.
     *            - if it is "A" then player decides if its value is 1 or 11
     *            - the GOAL OF THE GAME
     *            - each player starts with two cards
     *            - player has to beat the dealer's hand without going over 21
     *
     * Game play:
     *            - start game with a welcome greeting
     *            - ask player if he/she wants to play?
     *            - if NO - END GAME
     *
     *            - if YES - START GAME
     *               1. create a DECK of 52 cards, then shuffle it (randomize order)
     *               2. deal 2 cards to player, and 2 cards to dealer
     *               3. display player cards and sum of player's cards on the console
     *               4. display dealer's first card and the value of the first card
     *               4. ask player "would you like a hit?"
     *               5. if NO  - Check if dealer needs more cards
     *                             - dealer - you have 2 options:
     *                                 - either set a fixed value to dealers hand (18) (You can start with this)
     *                                                     or
     *                                 - The dealer hits until their sum of card at least 17 (Then upgrade to this)
     *                         - compare the sum
     *                         - display WINNER
     *                         - END GAME with come again greeting
     *                  if YES - deal 1 card to player
     *                         - recalculate sum
     *
     *               6. ask player "would you like another hit?"
     *               7. REPEAT step 5 until:
     *                                  - player decides to stop
     *                                  - player/dealer sum goes over 21 (No need to draw card for dealer, END GAME)
     *                                  - player/dealer hits 21
     *               8. - Check if dealer needs more cards
     *                            - either set a fixed value to dealers hand (18)
     *                              or
     *                            - The dealer hits until their sum of card at least 17
     *              9. DISPLAY RESULT OF EACH HAND
     *              10. DISPLAY WINNER
     *              11. END GAME WITH CONGRATZ GREETING
     *              12. BONUS - add money to the game, make the player and dealer bet
     *                        - implement rules that you know but not listed in this guide
     *                        - at step 11 ask player "would you like to play another game?"
     *                        - START NEW GAME
     *                        - REPEAT ALL STEPS
     *
     */

}

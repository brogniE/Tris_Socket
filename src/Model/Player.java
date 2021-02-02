package Model;
/**
 * L'interfaccia rappresenta le azioni obbligatorie che ciascun Player deve compiere
 */
public interface Player {
	/**
	 * Il metodo deve aggiornare le proprie informazioni sucessivamente alla recezione di una cella da parte del secondo Player
	 * @param c La cella inviata dal Player avversario
	 */
	public void risposta(Casella c);
	/**
	 * Il metodo deve gestire gli errori di conessione
	 */
	public void erroreConnessione();
	/**
	 * Il metodo chiude la connessione con il Plyer avversario
	 */
	public void chiudiConnessione();
	/**
	 * Il metodo invia al Player avversario la casellla selezionata
	 * @param c casella selezionata dall'utente
	 */
	public void inviaCasella(Casella c);
	/**
	 * Il metodo attende la ricezione di una risposta da parte dell'avversario
	 */
	public Casella riceviCasella();
	/**
	 * Il metodo avvia i controlli e le azioni sucessive al termine della partita
	 * @param v	probabile vincitore
	 */
	public void terminaPartita(int v);
}

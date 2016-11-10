package fr.upmc.dar.enums;

public enum EventVisibility {

	
	PUBLIC ,
	PRIVATE ,
	INTRA_UNI ;
	
	/**
	 * Retourne un {@link EventVisibility} en fonction d'une {@link String} équivalente.
	 * 
	 * @param visibility
	 * @return
	 */
	
	public static EventVisibility stringToEventVisibility(String visibility) {
		switch (visibility) {
		case "public":
			return EventVisibility.PUBLIC;
		case "private":
			return EventVisibility.PRIVATE;
		case "university":
			return EventVisibility.INTRA_UNI;
		}
		return null;
	}
	
	public static String eventVisibilityToString(EventVisibility visibility) {
		switch (visibility) {
		case PUBLIC:
			return "public";
		case PRIVATE:
			return "private";
		case INTRA_UNI:
			return "university";
		}
		return null;
	}
}

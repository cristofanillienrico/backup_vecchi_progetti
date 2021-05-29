package esperimenti;

import java.util.Comparator;

public class ComparatorFiglio implements Comparator<Figlio> {
	@Override
	public  int compare(Figlio o1, Figlio o2) {
		return o1.getNome().compareTo(o2.getNome());

	}
}

import java.util.List;
import java.util.Scanner;

public class MainApplication {
	static final int OPERATION_INSERT = 1;
	static final int OPERATION_DELETE = 2;
	static final int OPERATION_SEARCH = 3;
	static final int OPERATION_EXIT = 4;

	public static void main(String[] args) {
		System.out.println("\n\n------ AVL Tree - Estruturas Avançadas de Dados (Unisinos) ------\n\n");

		Scanner in = new Scanner(System.in);

		System.out.println("Qual numero deseja comecar a arvore?");
		int firstNodeKey = in.nextInt();

		var avlTree = new AvlTree(new Node(firstNodeKey));

		System.out.println("AVL Tree: " + avlTree);

		int operation;

		do {
			System.out.println(
					"\nQual operação deseja realizar:\n" +
							"(" + OPERATION_INSERT + ") Inserir\n" +
							"(" + OPERATION_DELETE + ") Deletar\n" +
							"(" + OPERATION_SEARCH + ") Buscar\n" +
							"(" + OPERATION_EXIT + ") Sair");
			operation = in.nextInt();

			if (!List.of(OPERATION_INSERT, OPERATION_DELETE, OPERATION_SEARCH, OPERATION_EXIT).contains(operation)) {
				System.out.println("O valor digitado é inválido, informe uma das opções!");
				continue;
			}

			if (operation == OPERATION_EXIT) {
				System.out.println("Saindo...");
				continue;
			}

			System.out.println("Qual valor deseja?");
			var value = in.nextInt();

			switch (operation) {
				case OPERATION_INSERT -> {
					avlTree.insert(value);
					System.out.println("AVL Tree: " + avlTree);
				}
				case OPERATION_DELETE -> {
					avlTree.delete(value);
					System.out.println("AVL Tree: " + avlTree);
				}
				case OPERATION_SEARCH -> {
					var result = avlTree.search(value);
					var message = result == null ? "Não encontrou" : result.getKey();
					System.out.println("Nó: " + message);
				}
			}

		} while (operation != 4);
	}

}

export const Mascaratelefone = (telefone) => {
    if(telefone.length == 1 || telefone.length == 4) {
        telefone += "("
    } else if(telefone.length == 4) {
        telefone += ")"
    } else if(telefone.length == 5) {
        telefone += " "
    }
}
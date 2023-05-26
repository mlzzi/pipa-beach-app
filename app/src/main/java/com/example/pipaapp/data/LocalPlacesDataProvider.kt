package com.example.pipaapp.data

import com.example.pipaapp.R
import com.example.pipaapp.model.Place
import com.example.pipaapp.model.PlaceType

object LocalPlacesDataProvider {
    val allPlaces = mutableListOf(
        Place(
            id = 1,
            titleResourceId = R.string.praia_do_centro,
            textResource = """
            Entre as melhores praias de Pipa está a Praia do Centro. Como o nome diz, ela fica no centro da vila.
            
            Portanto, se você estiver hospedado próximo aos principais restaurantes e lojas na Av. Baía dos Golfinhos, principal rua de Pipa, você estará bem perto desta praia.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_do_centro,
            mapResourceDirections = "praia do centro, pipa",
            place = PlaceType.PRAIAS
        ),
        Place(
            id = 2,
            titleResourceId = R.string.praia_do_amor,
            textResource = """
            Eu não surfo, mas bem que gostaria! Se eu praticasse o esporte, com certeza iria para lá curtir umas ondas. Descobri no site oficial de Pipa que algumas das mais importantes competições de surf da região são decididas nesta praia, que deu a fama que a Pipa tem.
            
            A praia é ótima pra pegar sol também, um pouco agitada para banhistas, mas super bonita e agradável. O canto direito é mais calmo e no canto esquerdo tem umas pedras que formam um cantinho especial, que vale ser explorado.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_do_amor,
            mapResourceDirections = "praia do amor, pipa",
            place = PlaceType.PRAIAS
        ),
        Place(
            id = 3,
            titleResourceId = R.string.braia_dos_golfinhos,
            textResource = """
            A Baía dos Golfinhos não poderia ficar de fora das lista das melhores praias de Pipa. Afinal, ela foi eleita uma das praias mais bonitas do mundo segundo o TripAdvisor.
        
            Como o nome diz, há golfinhos por aqui, mas, confesso, não encontramos nenhum. Nós vimos muitos mesmo foi na Praia do Madeiro (falaremos mais adiante dela).
        
            A Baía dos Golfinhos é realmente linda, mas é bom tomar bastante cuidado com as falésias como já falamos aqui.
        
            Além disso, vale ficar atento à maré, já que o acesso só é possível na maré baixa.
        """.trimIndent(),
            imageResourceId = R.drawable.baia_dos_golfinhos,
            mapResourceDirections = "praia baia dos golfinhos, pipa",
            place = PlaceType.PRAIAS
        ),
        Place(
            id = 4,
            titleResourceId = R.string.pousada_toa_toa,
            textResource = """
            Você está procurando um lugar aconchegante e econômico para ficar em Pipa? A Pousada Toa Toa Em Pipa é o lugar perfeito para você! Com sua decoração simples e acolhedora, esta suíte tem banheiro privativo, cama de casal e uma cama flutuante e ar-condicionado oferecendo tudo o que você precisa para uma estadia confortável, agradável e em conta.

            A pousada oferece uma piscina, estacionamento privativo, cozinha compartilhada e um jardim e está localizada a apenas 50 metros da Praia do Amor e a 500 metros do centro de Pipa. Com fácil acesso a lojas, restaurantes e atividades ao ar livre, você terá tudo o que precisa para aproveitar ao máximo sua estadia em Pipa.
        """.trimIndent(),
            imageResourceId = R.drawable.pousada_toa_toa,
            mapResourceDirections = "pousada toa toa, pipa",
            place = PlaceType.HOTÉIS
        ),
        Place(
            id = 5,
            titleResourceId = R.string.pousada_paraiso_das_tartarugas,
            textResource = """
            Situada na Praia de Sororoca, em Pipa, a Pousada Paraíso das Tartarugas dispõe de restaurante, bar, lounge compartilhado e jardim em Pipa. Esta propriedade dispõe de quartos família e churrasqueira. A acomodação oferece recepção 24 horas, balcão de turismo e serviço de câmbio.

            Um café da manhã continental é servido diariamente na pousada.

            A Pousada Paraíso das Tartarugas oferece um terraço. Você pode jogar bilhar na acomodação, que organiza aulas de kite surf e passeios de buggy.

            A Pousada Paraíso das Tartarugas fica a apenas 100 metros da Praia do Amor e a 200 metros da famosa Praia da Pipa. A Baía dos Golfinhos fica a 10 minutos a pé. São Gonçalo do. O Aeroporto Internacional de Amarante fica a 100 km de distância.
        """.trimIndent(),
            imageResourceId = R.drawable.pousada_paraiso_das_tartarugas,
            mapResourceDirections = "pousada paraiso das tartarugas, pipa",
            place = PlaceType.HOTÉIS
        ),
        Place(
            id = 6,
            titleResourceId = R.string.pousada_toca_da_coruja,
            textResource = """
            Situada na Praia de Pipa, em Tibau do Sul, a Pousada Toca da Coruja oferece bangalôs luxuosos com vista dos jardins e da floresta tropical, ocupando 25.000 m² ao redor da propriedade. A acomodação oferece 2 piscinas ao ar livre.

            Os bangalôs da Pousada Toca da Coruja são em plano aberto e decorados com móveis de madeira. As unidades dispõem de ar-condicionado e frigobar, bem como CD e DVD player.

            Além das piscinas ao ar livre, a propriedade inclui 3 piscinas ao ar livre. A Pousada Toca da Coruja também oferece sauna a vapor, banheira de hidromassagem e sala de leitura.

            Você poderá saborear pratos das culinárias internacional e regional no restaurante. Além disso, o bar serve uma grande variedade de bebidas, incluindo coquetéis especiais.
        """.trimIndent(),
            imageResourceId = R.drawable.pousada_toca_da_coruja,
            mapResourceDirections = "pousada toca da coruja, pipa",
            place = PlaceType.HOTÉIS
        ),
        Place(
            id = 7,
            titleResourceId = R.string.pizzaria_do_ademilson,
            textResource = """
            A pizzaria do Ademilson é o local perfeito para desfrutar dos dois pratos mais tradicionais da Itália, a pizza e o filé à parmeggiana.
            
            Com um preço super justo dada a qualidade da comida, é bom chegar cedo para conseguir uma mesa disputada no restaurante.
        """.trimIndent(),
            imageResourceId = R.drawable.pizzaria_do_ademilson,
            mapResourceDirections = "pizzaria do ademilson, pipa",
            place = PlaceType.RESTAURANTES
        ),
        Place(
            id = 8,
            titleResourceId = R.string.tres_empanadas,
            textResource = """
            Com uma variedade de mais de seis sabores que combinam o paladar do sul com as delícias do mar. 
            
            Tudo começou com um pequeno stand na praia do Madeiro. Hoje recebem quem quer saborear os seus produtos tanto na via principal da zona, a Avenida Baia dos Golfinhos, como também na praia.
            
            Um lugar com muito sabor no coração da Praia da Pipa.
        """.trimIndent(),
            imageResourceId = R.drawable.tres_empanadas,
            mapResourceDirections = "tres empanadas, pipa",
            place = PlaceType.RESTAURANTES
        ),
        Place(
            id = 9,
            titleResourceId = R.string.manas,
            textResource = """
            Pizzas, esfihas, salgados e bebidas. O local perfeito para o lanche rápido.
            
            Encontre encomendas de Tortas, doces e bolos.
        """.trimIndent(),
            imageResourceId = R.drawable.mana_doce_sabor,
            mapResourceDirections = "mana doce sabor, pipa",
            place = PlaceType.RESTAURANTES
        ),
        Place(
            id = 10,
            titleResourceId = R.string.praia_do_madeiro,
            textResource = """
            Essa praia é uma delícia para relaxar, com águas em tom verde esmeralda, calminhas e convidativas.
            
            Uma caminhada pela praia com um mergulho no cair da tarde pode ser uma excelente maneira de terminar o dia.
            
            Com o reflexo das falésias e das árvores na água, o que você encontra é praticamente um quadro pintado à mão na sua frente.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_do_madeiro,
            mapResourceDirections = "praia do madeiro, pipa",
        ),
        Place(
            id = 11,
            titleResourceId = R.string.praia_da_cancela,
            textResource = """
            Embora fique perto da Praia do Amor, entre ela e a Praia das Minas, a Praia da Cancela é totalmente deserta e sem estrutura. Vale mesmo conhecer só se você gosta de fazer uma caminhada pela areia. Mas só é possível na maré baixa.
        
            É outra área de proteção e desova de tartarugas. Da faixa de areia, uma escada encravada nas falésias dá acesso ao alto do Chapadão. Não há estrutura de barraca ou ambulantes.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_da_cancela,
            mapResourceDirections = "praia da cancela, pipa"
        ),
        Place(
            id = 12,
            titleResourceId = R.string.praia_das_minas,
            textResource = """
            Embora não fique muito longe do centro da vila de Pipa, a Praia das Minas praticamente deserta. Muito se deve à pouca estrutura e também às ondas e ventos fortes, mesmo na maré baixa.
        
            Está localizada depois do Chapadão, numa caminhada de cerca de 30 min do centrinho. Outra opção é ir de táxi.
            
            Inclusive do alto do Chapadão é possível ter uma vista bem bonita dessa praia. Embora aberta aos turistas, é uma área de preservação ambiental e desova de tartarugas.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_das_minas,
            mapResourceDirections = "praia das minas, pipa"
        ),
        Place(
            id = 13,
            titleResourceId = R.string.praia_da_cacimbinha,
            textResource = """
            O Mirante da Praia da Cacimbinha é parada obrigatória ao percorrer a estrada RN-003.
            
            Entre Tibau e a Praia do Madeiro, fica localizada a Cacimbinhas. Você pode chegar à praia descendo a escadaria da rodovia a beira mar ou caminhando pela praia.
            
            Lá encontram-se muitos praticantes do kitesurf, bem como dunas para a prática de sandboard e falésias que são base para voo livre.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_da_cacimbinha,
            mapResourceDirections = "praia da cacimbinha, pipa"
        ),
        Place(
            id = 14,
            titleResourceId = R.string.praia_do_giz,
            textResource = """
            Embora não esteja em Pipa, a Praia do Giz, em Tibau do Sul, também vale a visita, já que é bem espaçosa, bonita e tem estrutura.
            
            Aliás, bem perto dela está a Lagoa Guaraíras e seu incrível pôr do sol. Ou seja, dá para conhecer tudo em uma visita só.
        
            A Praia do Giz possui estrutura nas duas pontas, uma bem perto da Lagoa Guaraíras ou do outro lado, onde está a Ponta do Pirambu.
        """.trimIndent(),
            imageResourceId = R.drawable.praia_do_giz,
            mapResourceDirections = "praia do giz, pipa"
        ),
        Place(
            id = 15,
            titleResourceId = R.string.hotel_marlins,
            textResource = """
            Localizado no centro da Praia de Pipa, o Boutique Hotel Marlin's oferece acesso privativo à praia, quartos com vista para o mar e uma piscina ao ar livre. O hotel fica a 30 metros de restaurantes, bares e lojas. O Wi-Fi e o estacionamento são gratuitos.

            O Boutique Hotel Marlin's possui 2 edifícios, um à beira-mar e outro nos fundos, com algumas categorias de quartos com vista para o mar. O Terminal Rodoviário de Tibau do Sul fica a 100 metros da propriedade, e o Aeroporto Internacional de São Gonçalo do Amarante situa-se a 100 km.
        """.trimIndent(),
            imageResourceId = R.drawable.hotel_marlins,
            mapResourceDirections = "hotel marlins, pipa",
            place = PlaceType.HOTÉIS
        ),
        Place(
            id = 16,
            titleResourceId = R.string.hotel_sombra_agua_fresca,
            textResource = """
            O Sombra e Água Fresca oferece vista do mar e da floresta circundante, 3 piscinas e WiFi gratuito, a apenas 50 metros da Praia do Amor.
            
            Os quartos possuem vista do mar ou da floresta. Alguns têm uma banheira de hidromassagem ou uma piscina privativa mediante disponibilidade.

            A piscina do hotel possui vista panorâmica das praias Chapadão e do Amor.

            O Hotel Sombra e Água Fresca está situado a 500 metros do centro da cidade.
        """.trimIndent(),
            imageResourceId = R.drawable.hotel_sombra_agua_fresca,
            mapResourceDirections = "hotel sombra e agua fresca, pipa",
            place = PlaceType.HOTÉIS
        ),
        Place(
            id = 17,
            titleResourceId = R.string.hostel_do_ceu,
            textResource = """
            Este albergue, a apenas 200 metros da Praia Central de Pipa, oferece churrasqueira, e piscina rodeada por jardins. A propriedade dispõe de Wi-Fi gratuito e sala de TV.

            O Hostel do Céu oferece a você uma localização bastante central. Situa-se a 80 metros da badalada avenida Baía dos Golfinhos e da estação rodoviária de Pipa.

            A Praia dos Golfinhos fica a 10 minutos a pé, enquanto o Aeroporto Internacional de São Gonçalo do Amarante está a 100 km.
        """.trimIndent(),
            imageResourceId = R.drawable.hostel_do_ceu,
            mapResourceDirections = "hostel do ceu, pipa",
            place = PlaceType.HOTÉIS
        ),
        Place(
            id = 18,
            titleResourceId = R.string.acai_da_pipa,
            textResource = """
            No Açaí da Pipa você encontra a maior variedade de saboras de açaí de pipa, são mais de dez.
             
            Aqui você também encontra uma boa variedade de sorvetes, como o famoso sorvete de tapioca.
            
            Além disso, disfrute de sua deliciosa sobremesa gelada com uma vista incrível da praia do Centro.
        """.trimIndent(),
            imageResourceId = R.drawable.acai_da_pipa,
            mapResourceDirections = "açai da pipa, pipa",
            place = PlaceType.RESTAURANTES
        ),
        Place(
            id = 19,
            titleResourceId = R.string.manaki,
            textResource = """
            Venha ter uma experiência da gastronomia da Nova Zelândia! Culinária internacional com toques pessoais da Chef Karla de Sá.
            
            Venha nos visitar!!!
        """.trimIndent(),
            imageResourceId = R.drawable.manaki,
            mapResourceDirections = "restaurante manaki, pipa",
            place = PlaceType.RESTAURANTES
        ),
        Place(
            id = 20,
            titleResourceId = R.string.gelateria_preciosa,
            textResource = """
            Somos a Preciosa Gelateria Artesanal Italiana, 100% artesanal e localizada em um pedacinho do paraíso no Nordeste brasileiro, a Praia de Pipa, no Rio Grande do Norte.
            
            Graças à muita dedicação ao trabalho, a excelente qualidade do Gelato Preciosa foi conhecida rapidamente por moradores de Pipa, turistas brasileiros e internacionais e pela mídia especializada.
        """.trimIndent(),
            imageResourceId = R.drawable.gelateria_preciosa,
            mapResourceDirections = "gelateria preciosa, pipa",
            place = PlaceType.RESTAURANTES
        ),
        Place(
            id = 21,
            titleResourceId = R.string.tribus,
            textResource = """
            Há quatorze anos, no coração da paradisíaca Praia da Pipa, foi aberto inesperadamente por uma jovem apaixonada pela vida, o Tribus Bar, que vem se renovando e atualizando a cada dia que passa, cada cliente que cativa e cada opinião que recebe, no intuito de trazer à todos: alegria, diversão e ótimas experiências.

            Como grande admiradores da boa música, recebemos diversos músicos locais em diferentes dias da semana com repertórios que caminham entre Bossa Nova, MPB, Jazz, Rock e Pop Rock, nacional e internacional.

            Sinta-se nosso convidado especial. Será um prazer recebê-la em nosso espaço!
        """.trimIndent(),
            imageResourceId = R.drawable.tribus,
            mapResourceDirections = "tribus, pipa",
            place = PlaceType.BARES
        ),
        Place(
            id = 22,
            titleResourceId = R.string.taipa,
            textResource = """
            Nossa casa foi a antiga residência das parteiras da região que vinham para Pipa ajudar as grávidas a dar a luz e trazer as novas gerações para habitar nossa praia. E já se passaram mais de cinquenta anos e hoje fazemos questão de manter a energia original de uma Pipa de algum tempo atrás.

            A Taipa Brasil hoje é sinônimo de felicidade, alegria e diversão na praia da Pipa.Trabalhamos com música ao vivo de terça a sábado. Abrimos nossa casa de segunda a domingo a partir das 11h30 para almoço e à noite com bebidas, lanches e comida.

            Todas as noites pode desfrutar de diferentes espectáculos ao vivo que tornam ao Taipa uma visita necessaria para os turistas e residentes.
        """.trimIndent(),
            imageResourceId = R.drawable.taipa,
            mapResourceDirections = "taipa, pipa",
            place = PlaceType.BARES
        ),
        Place(
            id = 23,
            titleResourceId = R.string.agora,
            textResource = """
            Com vista para o mar, bem no centro da Pipa, o Agora Lounge Bar oferece um ambiente bem agradável, com boa ventilação, música ao vivo.
            
            Além disso, possui gastronomia refinada, drinks especiais, vista maravilhosa e um atendimento de 1º qualidade.
        """.trimIndent(),
            imageResourceId = R.drawable.agora,
            mapResourceDirections = "agora club, pipa",
            place = PlaceType.BARES
        ),
        Place(
            id = 24,
            titleResourceId = R.string.dudo,
            textResource = """
            Localizado dentro da Galeria Pipa Mar, o Dudo Bar é um dos principais locais de agito na noite de Pipa.
            
            Com variedade nos estilos musicais, divirta-se e dance ao sem de funk, pop internacional e black music.
        """.trimIndent(),
            imageResourceId = R.drawable.dudo,
            mapResourceDirections = "dudo bar, pipa",
            place = PlaceType.BARES
        ),
        Place(
            id = 25,
            titleResourceId = R.string.bakana,
            textResource = """
            Música Latina e Brasileira. Venha se divertir com a gente!
        """.trimIndent(),
            imageResourceId = R.drawable.bakana,
            mapResourceDirections = "bakana, pipa",
            place = PlaceType.BARES
        ),
        Place(
            id = 26,
            titleResourceId = R.string.fonte,
            textResource = """
            No Fonte bar você encontra um local pequeno, mas super aconchegante. Sua entrada discreta te leva para um local que te deixa super a vontade.
            
            No quesito música não há do que reclamar. Escute reggae, mpb, jazz e muito mais.
        """.trimIndent(),
            imageResourceId = R.drawable.fonte,
            mapResourceDirections = "av. baia dos golfinhos, 714, pipa",
            place = PlaceType.BARES
        ),
        Place(
            id = 27,
            titleResourceId = R.string.ubs,
            textResource = """
            A Unidade Básica de Saúde de Pipa fica na rua principal de pipa, na rua Baía dos Golfinhos, número 280.
            
            O horário de atendimento é das 7h00 às 15h30 de segunda a sexta.
            
            Caso necessite atendimento 24 horas, diriga-se ao Hospital Municipal de Tibau do Sul.
        """.trimIndent(),
            imageResourceId = R.drawable.ubs,
            mapResourceDirections = "ubs, pipa",
            place = PlaceType.UTILIDADES
        ),
        Place(
            id = 28,
            titleResourceId = R.string.rodoviaria,
            textResource = """
            O terminal de onibus fica logo na entrada de Pipa, na principal rua Baía dos Golfinhos.
            
            Horários: PIPA-NATAL
            5:00 | 6:00 | 7:00 | 9:00 | 10:00 | 11:00 | 13:00 | 14:00 | 15:00 | 16:00 | 17:00 | 18:30.

            Horários: NATAL-PIPA
            6:00 | 7:00 | 8:00 | 9:30 | 11:00 | 12:00 | 13:00 | 14:10 | 15:00 | 16:00 | 17:00| 18:10

            A viagem dura aproximadamente 2 horas.
            O custo da passagem é de R$ 22,00 atualmente.
        """.trimIndent(),
            imageResourceId = R.drawable.rodoviaria,
            mapResourceDirections = "terminal, pipa",
            place = PlaceType.UTILIDADES
        ),
        Place(
            id = 29,
            titleResourceId = R.string.mercado,
            textResource = """
            O mercado Pai e Filho oferece a maior variedade de produtos de Pipa.
            
            Conhecido como Atacarejo, ganhe descontos ao comprar grandes quantidades.
        """.trimIndent(),
            imageResourceId = R.drawable.mercado,
            mapResourceDirections = "atacarejo pai e filho, pipa",
            place = PlaceType.UTILIDADES
        ),
        Place(
            id = 30,
            titleResourceId = R.string.farmacia,
            textResource = """
            Caso necessite produtos de farmácia, poderá encontrar na principal farmácia de Pipa
        """.trimIndent(),
            imageResourceId = R.drawable.farmacia,
            mapResourceDirections = "farmacia dose certa, av baia dos golfinhos, pipa",
            place = PlaceType.UTILIDADES
        ),
        Place(
            id = 31,
            titleResourceId = R.string.caixa,
            textResource = """
            Localizado no Kanto da Pipa, aqui poderá encontrar um banco 24 horas.
        """.trimIndent(),
            imageResourceId = R.drawable.caixa_24h,
            mapResourceDirections = "caixa 24 horas kanto da pipa, pipa",
            place = PlaceType.UTILIDADES
        )
    )

    val defaultPlace = allPlaces[0]
}
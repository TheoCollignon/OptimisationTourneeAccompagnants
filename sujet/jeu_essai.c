#include <stdio.h>

#define NBR_INTERFACES        10 
#define NBR_APPRENANTS	       8 
#define NBR_CENTRES_FORMATION  3 
#define NBR_SPECIALITES        3 
#define NBR_NODES 	       NBR_CENTRES_FORMATION+NBR_INTERFACES+NBR_APPRENANTS

/* code des compétence en langage des signes et en codage LPC */
#define COMPETENCE_SIGNES      0 
#define COMPETENCE_CODAGE      1 

/* competences des interfaces en SIGNES et CODAGE*/
int competences_interfaces[NBR_INTERFACES][2]={
    {1,0}, /* compétence en langages des SIGNES mais pas en CODAGE LPC */
    {0,1}, /* pas de compétence en langages des SIGNES mais compétence en CODAGE LPC */
    {0,1},
    {1,0},
    {0,1},
    {1,0},
    {1,0},
    {1,0},
    {0,1},
    {1,0}
};

/* spécialités des interfaces */
#define SPECIALITE_SANS       -1 
#define SPECIALITE_MENUISERIE  0 
#define SPECIALITE_ELECTRICITE 1 
#define SPECIALITE_MECANIQUE   2 

/* specialite des interfaces */
int specialite_interfaces[NBR_INTERFACES][NBR_SPECIALITES]={
    {1,0,0},
    {0,1,0},
    {0,0,0},
    {0,0,1},
    {0,1,0},
    {0,0,0},
    {0,1,0},
    {1,0,0},
    {1,0,0},
    {0,1,0}
};

/* coordonnées du centre, des interfaces et des apprenants */
float coord[NBR_NODES][2]=
{
    {565.0,575.0}, /* centre formation menuiserie */
    {25.0,185.0},  /* centre formation electricite */
    {345.0,750.0}, /* centre formation mecanique */
    {945.0,685.0}, /* point de départ interfaces */
    {845.0,655.0},
    {880.0,660.0},
    {25.0,230.0},
    {525.0,1000.0},
    {580.0,1175.0},
    {650.0,1130.0},
    {1605.0,620.0},
    {1220.0,580.0}, 
    {1465.0,200.0},
    {1530.0,5.0}, /* point de départ apprenants */
    {845.0,680.0},
    {725.0,370.0},
    {145.0,665.0},
    {415.0,635.0},
    {510.0,875.0},
    {560.0,365.0},
    {300.0,465.0}
} ;

#define NBR_FORMATION          9

#define LUNDI                  1
#define MARDI                  2
#define MERCREDI               3
#define JEUDI                  4
#define VENDREDI               5
#define SAMEDI                 6

/* formation : apprenant, specialite, competence, horaire debut formation, horaire fin formation */
int formation[NBR_FORMATION][6]=
{
    {0,SPECIALITE_ELECTRICITE, COMPETENCE_SIGNES, LUNDI, 13, 16},
    {1,SPECIALITE_MENUISERIE, COMPETENCE_CODAGE, MARDI, 8, 11},
    {2,SPECIALITE_ELECTRICITE, COMPETENCE_CODAGE, MERCREDI, 9, 12},
    {3,SPECIALITE_MECANIQUE, COMPETENCE_SIGNES, MARDI, 14, 17},
    {4,SPECIALITE_ELECTRICITE, COMPETENCE_SIGNES, LUNDI, 9, 12},
    {5,SPECIALITE_MENUISERIE, COMPETENCE_SIGNES, JEUDI, 8, 11},
    {0,SPECIALITE_ELECTRICITE, COMPETENCE_SIGNES, JEUDI, 8, 12},
    {6,SPECIALITE_SANS, COMPETENCE_CODAGE, JEUDI, 14, 17},
    {7,SPECIALITE_ELECTRICITE, COMPETENCE_CODAGE, VENDREDI, 8, 11}
} ;

int main() {
    printf("NBR_INTERFACES=%d\n",NBR_INTERFACES) ;
    printf("NBR_APPRENANTS=%d\n",NBR_APPRENANTS) ;
    printf("NBR_NODES=%d\n",NBR_NODES) ;

    return 0 ;
}
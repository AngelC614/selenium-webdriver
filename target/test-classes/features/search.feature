Feature: Login

Scenario Outline: Login Eva

Given El usuario entra en la pagina
When El <user> ingresa su cuenta
And El usuario preciona en Comencemos
Then El usuario Entra en la pagina

Examples:
| user       |
| CH75665179 |


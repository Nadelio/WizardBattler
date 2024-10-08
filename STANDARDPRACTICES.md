# Standard Practices for Modding or Adding New Features

#### weakType/strongType formatting
- ALL CAPS
- Underscores_instead_of_spaces
- EX: ``"FIRE"``, ``"DAMAGE_OVER_TIME"``, etc.
- **EXCEPTION: ``"isPlayer"``, this is to help differentiate even further between enemy/player**
# 
#### EntityClass enum entry formatting
- First letter capatilized
- Underscores_instead_of_spaces
- EX: ``Fighter``, ``Wizard_of_the_forest``, etc.
# 
#### New action/spellName entry formatting
- First letter capatilized
- Underscores_instead_of_spaces
- EX: ``"Fireball"``, ``"Ball_of_fire"``, etc.
# 
#### New weaponName entry formatting
- all lowercase letters
- Underscores_instead_of_spaces
- EX: ``"sword"``, ``"staff_of_fire"``, etc.
#
### New weaponType entry formatting
- all lowercase letters
- Underscores_instead_of_spaces
- EX: ``"spear"``, ``"staff"``, ``"bow"``, etc.
# 
#### New entityName entry formatting
- all lowercase letters
- Underscores_instead_of_spaces
- EX: ``"skeleton"``, ``"mayor_of_kansas"``, etc.
#
#### New events/eventNames
- PascalCase
- Nospaces
- Ends with Event
    - Do not apply to eventNames
- EX: ``DamageTakenEvent``, ``"DamageTaken"``, ``HealthChangeEvent``, etc.
#
#### New Environements/Environment entries
- First letter capitilized
- Underscores_instead_of_spaces
- EX: ``"Plains"``, ``"City_ruins"``, etc.
#
#### Additions to DATABASE.md
- First the reader or wiki name for your addition
    - EX: ``Fireball``
- Then a semicolon
  - EX: ``Fireball:``
- Finally the reference name for the game
  - EX: ``Fireball: "Fireball"``
  - EX: ``Healing Prayer: "Healing_prayer"``
  - EX: ``Basic Sword: "basic_sword"``


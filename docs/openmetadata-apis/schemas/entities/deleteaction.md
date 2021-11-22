# LifecycleDeleteAction

An action to delete or expire the entity.

**$id:**[**https://open-metadata.org/schema/entity/data/dbtmodel.json**](https://open-metadata.org/schema/entity/policies/lifecycle/deleteAction.json)

Type: `object`

This schema <u>does not</u> accept additional properties.

## Properties
- **daysAfterCreation**
  - Number of days after creation of the entity that the deletion should be triggered.
  - Type: `integer`
  - Range:  &ge; 1
- **daysAfterModification**
  - Number of days after last modification of the entity that the deletion should be triggered.
  - Type: `integer`
  - Range:  &ge; 1
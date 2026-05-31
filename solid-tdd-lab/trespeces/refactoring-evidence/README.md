# Missile Management System
**Name:** Trespeces
**Branch:** solid-refactor-ut-trespeces

## Overview
Refactored Spring Boot project from GRASP lab. Improved using SOLID principles and OOP best practices.

## Already Good Design (Before Refactoring)
- DTO layer already separates entity from API response
- Repository interface already uses abstraction (DIP)
- LaunchMethod interface already supports polymorphism (OCP)
- Layered architecture already in place (Controller > Service > Repository)
- Constructor injection already reduces tight coupling

## SOLID Principles Applied
- **SRP** — MissileValidator handles validation, MissileMapper handles DTO conversion, MissileService handles business logic only
- **OCP** — LaunchMethod interface allows new launch types without modifying existing code
- **LSP** — AirLaunch and SeaLaunch are interchangeable via LaunchMethod interface
- **ISP** — LaunchMethod interface is focused, only execute() and getLaunchType()
- **DIP** — MissileService depends on interfaces, not concrete implementations

## OOP Best Practices
- **DRY** — MissileValidator centralizes all validation
- **KISS** — Simple if-else logic, no over-engineering
- **YAGNI** — Only built what was needed
- **Composition Over Inheritance** — Service uses Validator and Mapper via composition

## Unit Tests
14 unit tests covering service layer, polymorphism, edge cases, and dependency inversion.

## Refactoring Evidence
See `/refactoring-evidence/` folder for before/after screenshots.

## Retrospect
1. **Which principle improved your design the most?** SRP — separating validation and mapping made the Service cleaner.
2. **What bad design did you remove?** Validation logic embedded inside MissileService.
3. **Which principle was hardest to apply?** DIP — ensuring Service never instantiated concrete classes directly.

## Changelog
- SOLID-UT Completed
- Added MissileValidator and MissileMapper
- Added 14 unit tests
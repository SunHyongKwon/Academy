# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Advise(models.Model):
    apcode = models.CharField(primary_key=True, max_length=4)  # The composite primary key (apcode, ascode) found, that is not supported. The first column is selected.
    ascode = models.CharField(max_length=4)

    class Meta:
        managed = False
        db_table = 'advise'
        unique_together = (('apcode', 'ascode'),)


class AuthGroup(models.Model):
    name = models.CharField(unique=True, max_length=150)

    class Meta:
        managed = False
        db_table = 'auth_group'


class AuthGroupPermissions(models.Model):
    id = models.BigAutoField(primary_key=True)
    group = models.ForeignKey(AuthGroup, models.DO_NOTHING)
    permission = models.ForeignKey('AuthPermission', models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'auth_group_permissions'
        unique_together = (('group', 'permission'),)


class AuthPermission(models.Model):
    name = models.CharField(max_length=255)
    content_type = models.ForeignKey('DjangoContentType', models.DO_NOTHING)
    codename = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'auth_permission'
        unique_together = (('content_type', 'codename'),)


class AuthUser(models.Model):
    password = models.CharField(max_length=128)
    last_login = models.DateTimeField(blank=True, null=True)
    is_superuser = models.IntegerField()
    username = models.CharField(unique=True, max_length=150)
    first_name = models.CharField(max_length=150)
    last_name = models.CharField(max_length=150)
    email = models.CharField(max_length=254)
    is_staff = models.IntegerField()
    is_active = models.IntegerField()
    date_joined = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'auth_user'


class AuthUserGroups(models.Model):
    id = models.BigAutoField(primary_key=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)
    group = models.ForeignKey(AuthGroup, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'auth_user_groups'
        unique_together = (('user', 'group'),)


class AuthUserUserPermissions(models.Model):
    id = models.BigAutoField(primary_key=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)
    permission = models.ForeignKey(AuthPermission, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'auth_user_user_permissions'
        unique_together = (('user', 'permission'),)


class Course(models.Model):
    ccode = models.CharField(primary_key=True, max_length=4)
    cname = models.CharField(max_length=10, blank=True, null=True)
    ctime = models.IntegerField(blank=True, null=True)
    croom = models.CharField(max_length=8, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'course'


class Daumlist(models.Model):
    rank = models.BigIntegerField(blank=True, null=True)
    title = models.TextField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'daumlist'


class DjangoAdminLog(models.Model):
    action_time = models.DateTimeField()
    object_id = models.TextField(blank=True, null=True)
    object_repr = models.CharField(max_length=200)
    action_flag = models.PositiveSmallIntegerField()
    change_message = models.TextField()
    content_type = models.ForeignKey('DjangoContentType', models.DO_NOTHING, blank=True, null=True)
    user = models.ForeignKey(AuthUser, models.DO_NOTHING)

    class Meta:
        managed = False
        db_table = 'django_admin_log'


class DjangoContentType(models.Model):
    app_label = models.CharField(max_length=100)
    model = models.CharField(max_length=100)

    class Meta:
        managed = False
        db_table = 'django_content_type'
        unique_together = (('app_label', 'model'),)


class DjangoMigrations(models.Model):
    id = models.BigAutoField(primary_key=True)
    app = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    applied = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'django_migrations'


class DjangoSession(models.Model):
    session_key = models.CharField(primary_key=True, max_length=40)
    session_data = models.TextField()
    expire_date = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'django_session'


class Lecture(models.Model):
    lpcode = models.CharField(primary_key=True, max_length=4)  # The composite primary key (lpcode, lccode) found, that is not supported. The first column is selected.
    lccode = models.CharField(max_length=4)
    opendate = models.DateField(blank=True, null=True)
    closedate = models.DateField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'lecture'
        unique_together = (('lpcode', 'lccode'),)


class Professor(models.Model):
    pcode = models.CharField(primary_key=True, max_length=4)
    pname = models.CharField(max_length=10, blank=True, null=True)
    pdept = models.CharField(max_length=12, blank=True, null=True)
    pphone = models.CharField(max_length=12, blank=True, null=True)
    paddress = models.CharField(max_length=50, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'professor'


class Register(models.Model):
    rscode = models.CharField(primary_key=True, max_length=4)  # The composite primary key (rscode, rccode) found, that is not supported. The first column is selected.
    rccode = models.CharField(max_length=4)
    score = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'register'
        unique_together = (('rscode', 'rccode'),)


class Score(models.Model):
    v1 = models.BigIntegerField(db_column='V1', blank=True, null=True)  # Field name made lowercase.
    v2 = models.BigIntegerField(db_column='V2', blank=True, null=True)  # Field name made lowercase.
    v3 = models.BigIntegerField(db_column='V3', blank=True, null=True)  # Field name made lowercase.
    v4 = models.BigIntegerField(db_column='V4', blank=True, null=True)  # Field name made lowercase.

    class Meta:
        managed = False
        db_table = 'score'


class Student(models.Model):
    scode = models.CharField(primary_key=True, max_length=4)
    sname = models.CharField(max_length=10, blank=True, null=True)
    sdept = models.CharField(max_length=12, blank=True, null=True)
    sphone = models.CharField(max_length=12, blank=True, null=True)
    saddress = models.CharField(max_length=45, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'student'


class User(models.Model):
    uid = models.CharField(primary_key=True, max_length=45)
    upw = models.CharField(max_length=45, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'user'
